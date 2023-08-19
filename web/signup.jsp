<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form class="form-group mb-3 mt-3" action="signup" method="post">

    <label class="form-label">Sign up</label>

    <div class="form-group mb-3">
        <input class="form-control" type="email" name="email" placeholder="Email" required>
    </div>

    <div class="form-group mb-3">
        <input class="form-control" type="number" name="identification" placeholder="Identification" required>
    </div>

    <div class="form-group mb-3">
        <input class="form-control" type="password" name="password" placeholder="Password" required>
    </div>

    <div class="form-group mb-3">
        <input class="btn btn-primary w-100" type="submit" value="SignUp">
    </div>

</form>