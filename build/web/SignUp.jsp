<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Document</title>
</head>
<body>

    <div class="container">
         <h1>Registration here !!</h1>
         <p id="msg"></p>
        <div class="card" id="card">
           
            <form  action ="Registration" id="registration" class="form">
                <input type="text" name="user_name" placeholder="Enter your name" required> <br>
                <input type="email" name="user_email" placeholder="Enter your email" required><br>
                <input type="password" name="user_password" placeholder="Enter your password" required> <br>
                <button type="submit"> Registration</button>

            </form>

     

        </div>

        <div class="processBar" id="loader">
            <div class="loader"></div>
            <h5>Please Wait....</h5>
        </div>

    </div>

    
</body>
 <script src="register.js"></script>
</html>
