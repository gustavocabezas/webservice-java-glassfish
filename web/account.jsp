<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form action="login" method="post" class="form mt-3">



    <div class="form-group mb-3"> 

        <div class="form-group mb-3">
            <img src="${imageAvatarPath}" class="rounded-circle" width="150" height="150"/> 
            <br /><br />
            <input type="file" name="FileUploadImage" class="form-control" accept="image/*">
        </div>

        <div class="form-group mb-3">
            <input class="form-control" type="text" name="username" placeholder="User Name">
        </div> 

        <div class="form-group mb-3">
            <input class="form-control" type="text" name="firstname" placeholder="First Name" > 
        </div> 

        <div class="form-group mb-3">
            <input class="form-control" type="text" name="lastname" placeholder="Last Name" >
        </div> 
 
        <div class="form-group mb-3">
            <input class="form-control" type="email" name="email" placeholder="Email" required>
        </div> 

        <div class="form-group mb-3">
            <input class="form-control" type="password" name="password" placeholder="Password" required>
        </div> 

        <div class="form-group mb-3">
            <input class="btn btn-primary" type="submit" value="Update">
            <input class="btn btn-danger" type="submit" value="Delete">
        </div> 
</form>