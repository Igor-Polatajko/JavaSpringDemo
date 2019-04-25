<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function() {
            $(".delete_contact_submit").click(function () {

                $.ajax({
                    url: '/api/delete/' + this.id,
                    type: 'DELETE',
                    data: ""
                    });

                location.reload();
                });
            });
    </script>
</head>
<body>

<h1>Persons</h1>

<h3><a href="/create">Create new contact</a></h3>

<ul id="personsList">
    <#list persons as person>
    <li class="item">
        <b>${person.name}</b> (age: ${person.age}) - <i><#if person.phoneNumber??>${person.phoneNumber}<#else>No number available</#if></i>
        <input type="submit" value="delete" class="delete_contact_submit" id="${person.id}">
    </li>
    <#else>
    <h2>List is empty!</h2>
    </#list>
</ul>

</body>
</html>