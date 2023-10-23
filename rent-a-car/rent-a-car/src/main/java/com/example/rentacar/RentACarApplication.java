package com.example.rentacar;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@SpringBootApplication
@RestController
public class RentACarApplication {

    private final UserEntityRepository entityService;
    private final TokenEntityRepository tokenEntityService;
    private final CarEntityRepository carEntityService;

    @Autowired
    public RentACarApplication(UserEntityRepository entityService, UserEntityRepository entityService1, TokenEntityRepository tokenEntityRepository, CarEntityRepository carEntityService) {
        this.entityService = entityService1;
        this.tokenEntityService = tokenEntityRepository;
        this.carEntityService = carEntityService;
    }

    public static void main(String[] args) {
        SpringApplication.run(RentACarApplication.class, args);
    }

    public static String generateRandomString(int length) {
        // Define the characters that can be used in the random string
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Create a StringBuilder to store the random string
        StringBuilder randomStringBuilder = new StringBuilder(length);

        // Create a Random object to generate random indices
        Random random = new Random();

        // Generate random characters and append them to the StringBuilder
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            randomStringBuilder.append(randomChar);
        }

        // Convert the StringBuilder to a string
        return randomStringBuilder.toString();
    }

    // Private method to extract the user ID from the token
    private Long getUserIdFromToken(String token) {
        Optional<TokenEntity> tokenEntityOptional = tokenEntityService.findByToken(token);

        if (tokenEntityOptional.isPresent()) {
            TokenEntity tokenEntity = tokenEntityOptional.get();
            return tokenEntity.getUser_id();
        }

        return null; // Return null if the token is not valid or not found
    }

    @PostMapping(value = "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postLogin(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .toList();

            ErrorResponse errorResponse = new ErrorResponse("Validation failed");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Optional<UserEntity> userOptional = entityService.findByUsername(username);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            if (BCrypt.checkpw(password, user.getPassword())) {

                String token = generateRandomString(64);

                TokenEntity tokenEntity = new TokenEntity();
                tokenEntity.setToken(token);
                tokenEntity.setUser_id(user.getId());
                this.tokenEntityService.save(tokenEntity);

                // Create a JSON response with the "token" field
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("token", token); // Set the token value here

                return ResponseEntity.status(200).body(jsonResponse);

            } else {

                ErrorResponse errorResponse = new ErrorResponse("Incorrect password");
                return ResponseEntity.badRequest().body(errorResponse);
            }
        } else {

            ErrorResponse errorResponse = new ErrorResponse("Incorrect password");
            return ResponseEntity.badRequest().body(errorResponse);
        }

    }


    @PostMapping(value = "/auth/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postRegister(@Valid @RequestBody RegisterRequest loginRequest, BindingResult result) {

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .toList();

            ErrorResponse errorResponse = new ErrorResponse("Validation failed");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        entityService.save(user);

        String token = generateRandomString(64);

        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setToken(token);
        tokenEntity.setUser_id(user.getId());
        this.tokenEntityService.save(tokenEntity);

        // Create a JSON response with the "token" field
        Map<String, Object> jsonResponse = new HashMap<>();
        jsonResponse.put("token", token); // Set the token value here

        return ResponseEntity.status(200).body(jsonResponse);

    }


    @GetMapping(value = "/member/cars/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarEntity> getMemberCar(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) Optional<String> authorizationHeader) {

        if (authorizationHeader.isPresent()) {
            String token = authorizationHeader.get();

            Long userId = getUserIdFromToken(token);

            if (userId != null) {

                Optional<CarEntity> car  = carEntityService.findByUserIdAndId(userId, id);

                return car.map(carEntity -> ResponseEntity.status(HttpStatus.OK).body(carEntity)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));

            }

        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

    }


    @GetMapping(value = "/member/cars", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarsResponse> getMemberCars(@RequestHeader(HttpHeaders.AUTHORIZATION) Optional<String> authorizationHeader, @RequestParam(required = false) Optional<String> query) {

        if (authorizationHeader.isPresent()) {
            String token = authorizationHeader.get();

            Long userId = getUserIdFromToken(token);

            if (userId != null) {

                String namePattern = query.map(n -> "%" + n + "%").orElse(null);

                List<CarEntity> cars = carEntityService.findAllByUserId(userId, namePattern);

                Long total = (long) cars.size();

                CarsResponse carsResponse = new CarsResponse(cars, total);

                return ResponseEntity.status(HttpStatus.OK).body(carsResponse);
            }

        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

    }


    @PostMapping(value = "/member/cars", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postMemberCars(@Valid @RequestBody CarRequest carRequest, BindingResult result, @RequestHeader(HttpHeaders.AUTHORIZATION) Optional<String> authorizationHeader) {

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .toList();

            ErrorResponse errorResponse = new ErrorResponse("Validation failed");
            return ResponseEntity.badRequest().body(errorResponse);
        }


        if (authorizationHeader.isPresent()) {
            String token = authorizationHeader.get();

            Long userId = getUserIdFromToken(token);

            if (userId == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }

            CarEntity car = new CarEntity();
            car.setName(carRequest.getName());
            car.setPlaka(carRequest.getPlaka());
            car.setBrand(carRequest.getBrand());
            car.setModel(carRequest.getModel());
            car.setYear(carRequest.getYear());
            car.setUserId(userId);
            carEntityService.save(car);

            String jsonResponse = "{\"message\": \"success\"}";
            // Your logic to process the login request
            return ResponseEntity.status(200).body(jsonResponse);

        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

    }

    @PutMapping(value = "/member/cars", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putMemberCars(@Valid @RequestBody CarUpdateRequest carUpdateRequest, BindingResult result, @RequestHeader(HttpHeaders.AUTHORIZATION) Optional<String> authorizationHeader) {

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .toList();

            ErrorResponse errorResponse = new ErrorResponse("Validation failed");
            return ResponseEntity.badRequest().body(errorResponse);
        }


        if (authorizationHeader.isPresent()) {
            String token = authorizationHeader.get();

            Long userId = getUserIdFromToken(token);

            if (userId == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }

            Optional<CarEntity> foundCar = carEntityService.findByUserIdAndId(userId, carUpdateRequest.getId());

            if (foundCar.isEmpty()) {
                ErrorResponse errorResponse = new ErrorResponse("Car not found");
                return ResponseEntity.badRequest().body(errorResponse);
            }

            CarEntity car = foundCar.get();
            car.setName(carUpdateRequest.getName());
            car.setPlaka(carUpdateRequest.getPlaka());
            car.setBrand(carUpdateRequest.getBrand());
            car.setModel(carUpdateRequest.getModel());
            car.setYear(carUpdateRequest.getYear());
            car.setUserId(userId);
            carEntityService.save(car);

            String jsonResponse = "{\"message\": \"success\"}";
            // Your logic to process the login request
            return ResponseEntity.status(200).body(jsonResponse);

        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

    }

    @DeleteMapping(value = "/member/cars", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteMemberCars(@Valid @RequestBody DeleteCarRequest deleteCarRequest, BindingResult result, @RequestHeader(HttpHeaders.AUTHORIZATION) Optional<String> authorizationHeader) {

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .toList();

            ErrorResponse errorResponse = new ErrorResponse("Validation failed");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        if (authorizationHeader.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        String token = authorizationHeader.get();

        Long userId = getUserIdFromToken(token);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        Optional<CarEntity> foundCar = carEntityService.findByUserIdAndId(userId, deleteCarRequest.getId());

        if (foundCar.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse("Car not found");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        carEntityService.delete(foundCar.get());

        String jsonResponse = "{\"message\": \"success\"}";
        // Your logic to process the login request
        return ResponseEntity.status(200).body(jsonResponse);
    }

    @PostMapping(value = "/member/change-password", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postMemberCars(@Valid @RequestBody ChangePasswordRequest changePasswordRequest, BindingResult result, @RequestHeader(HttpHeaders.AUTHORIZATION) Optional<String> authorizationHeader) {

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .toList();

            ErrorResponse errorResponse = new ErrorResponse("Validation failed");
            return ResponseEntity.badRequest().body(errorResponse);
        }


        if (authorizationHeader.isPresent()) {
            String token = authorizationHeader.get();

            Long userId = getUserIdFromToken(token);

            if (userId == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }

            Optional<UserEntity> foundUser = entityService.findById(Math.toIntExact(userId));

            if (foundUser.isEmpty()) {
                ErrorResponse errorResponse = new ErrorResponse("User not found");
                return ResponseEntity.badRequest().body(errorResponse);
            }

            UserEntity user = foundUser.get();

            if (!BCrypt.checkpw(changePasswordRequest.getOldPassword(), user.getPassword())) {
                ErrorResponse errorResponse = new ErrorResponse("Old password is incorrect");
                return ResponseEntity.badRequest().body(errorResponse);
            }

            if (!changePasswordRequest.getPassword().equals(changePasswordRequest.getPasswordRepeat())) {
                ErrorResponse errorResponse = new ErrorResponse("New passwords do not match");
                return ResponseEntity.badRequest().body(errorResponse);
            }

            String hashedPassword = BCrypt.hashpw(changePasswordRequest.getPassword(), BCrypt.gensalt());

            user.setPassword(hashedPassword);
            entityService.save(user);

            String jsonResponse = "{\"message\": \"success\"}";
            // Your logic to process the login request
            return ResponseEntity.status(200).body(jsonResponse);

        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

    }

}

