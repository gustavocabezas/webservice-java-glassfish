
<%@page import="entity.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Users loggedUser = (Users) request.getSession().getAttribute("loggedUser");
%>

<!DOCTYPE html>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/webapplication-java-hibernate/">Home</a>
                </li>

                <% if (loggedUser == null) { %>
                <li class="nav-item">
                    <a class="nav-link" href="/webapplication-java-hibernate/login">Login</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/webapplication-java-hibernate/signup">Signup</a>
                </li>
                <% } else { %>
 
                <!--
                <li class="nav-item">
                    <a class="nav-link" href="/webapplication-java-hibernate/account">Account</a>
                </li>
                -->

                <li class="nav-item">
                    <a class="nav-link" href="/webapplication-java-hibernate/jobs">Jobs</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/webapplication-java-hibernate/logout">Logout</a>
                </li>
                <% }%>

            </ul>

            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
