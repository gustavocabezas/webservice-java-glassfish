<%@page contentType="text/html" pageEncoding="UTF-8"%>
<form class="form-group mb-3 mt-3" action="jobs" method="post">

    <label class="form-label">Jobs</label>
     
    <div class="form-group mb-3 d-flex">
        <input class="form-control" type="number" name="id" placeholder="id"  value="<%= request.getAttribute("id") != null ? request.getAttribute("id") : "" %>">
        <input class="btn btn-secondary w-25" type="submit" name="action" value="Get">
    </div>
    
    <div class="form-group mb-3">
        <input class="form-control" type="text" name="title" placeholder="Title" value="<%= request.getAttribute("title") != null ? request.getAttribute("title") : "" %>" >
    </div>

    <div class="form-group mb-3">
        <input class="form-control" type="text" name="description" placeholder="Description" value="<%= request.getAttribute("description") != null ? request.getAttribute("description") : "" %>" >
    </div>
    
    <div class="form-group mb-3">
        <input class="form-control" type="text" name="locationtext" placeholder="Location" value="<%= request.getAttribute("locationtext") != null ? request.getAttribute("locationtext") : "" %>" >
    </div>
    
    <div class="form-group mb-3">
        <input class="form-control" type="text" name="requirements" placeholder="requirements" value="<%= request.getAttribute("requirements") != null ? request.getAttribute("requirements") : "" %>" >
    </div>
    
    <div class="form-group mb-3">
        <input class="form-control" type="number" name="salary" placeholder="salary" value="<%= request.getAttribute("salary") != null ? request.getAttribute("salary") : "" %>" >
    </div>

    <div class="form-group mb-3 d-flex">
        <input class="btn btn-primary w-100" type="submit" name="action" value="Create">
        
        <input class="btn btn-secondary w-100" type="submit" name="action" value="Update">
        
        <input class="btn btn-danger w-100" type="submit" name="action" value="Delete">
    </div>

</form>