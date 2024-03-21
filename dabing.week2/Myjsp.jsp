<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#registrationForm").submit(function(event){
                var isValid = true;
                $(".error").remove();

                // Username validation
                var username = $("#username").val();
                if(username == ""){
                    $("#username").after("<span class='error'>Username is required</span>");
                    isValid = false;
                }

                // Password validation
                var password = $("#password").val();
                if(password == ""){
                    $("#password").after("<span class='error'>Password is required</span>");
                    isValid = false;
                } else if(password.length < 8){
                    $("#password").after("<span class='error'>Password must be at least 8 characters long</span>");
                    isValid = false;
                }

                // Email validation
                var email = $("#email").val();
                var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                if(email == ""){
                    $("#email").after("<span class='error'>Email is required</span>");
                    isValid = false;
                } else if(!emailRegex.test(email)){
                    $("#email").after("<span class='error'>Invalid email address</span>");
                    isValid = false;
                }

                // Birthdate validation
                var birthdate = $("#birthdate").val();
                var birthdateRegex = /^\d{4}-\d{2}-\d{2}$/;
                if(birthdate == ""){
                    $("#birthdate").after("<span class='error'>Birthdate is required</span>");
                    isValid = false;
                } else if(!birthdateRegex.test(birthdate)){
                    $("#birthdate").after("<span class='error'