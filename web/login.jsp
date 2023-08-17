<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form class="form-group mb-3 mt-3" action="login" method="post">
    
    <div class="form-group mb-3">
        <input class="form-control" type="email" name="email" placeholder="Email" required>
    </div>

    <div class="form-group mb-3">
        <input class="form-control" type="password" name="password" placeholder="Password" required>
    </div>

    <div class="form-group mb-3">
        <input class="btn btn-primary w-100" type="submit" value="Login">
    </div>
    
</form>