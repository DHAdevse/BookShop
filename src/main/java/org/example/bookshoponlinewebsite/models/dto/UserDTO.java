package org.example.bookshoponlinewebsite.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
   @NotEmpty(message = "First name cannot be empty")
   private String firstName;

   @NotEmpty(message = "Last name cannot be empty")
   private String lastName;

   @NotEmpty(message = "Email cannot be empty")
   @Email(message = "Please provide a valid email address")
   private String email;

   @NotEmpty(message = "Username cannot be empty")
   private String username;

   @NotEmpty(message = "Password cannot be empty")
   @Size(min = 6, message = "Password must be at least 6 characters long")
   private String password;
   private String confirmPassword;
   private List<Long> roleIdsList;
   public UserDTO(String username, String password, String firstName, String lastName, String email) {
      this.username = username;
      this.password = password;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
   // Getters and setters
}
