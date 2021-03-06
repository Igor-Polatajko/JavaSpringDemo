<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create contact</title>
</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $('#add_contact_submit').click(  function () {

            var sendInfo = {
                'name' : $("#name").val(),
                'phoneNumber' : $("#phoneNumber").val(),
                'age' : $("#age").val()
            };

            $("#result").text("");

            if(sendInfo.name.match(/^[\S]+$/)  && sendInfo.phoneNumber.match(/^[\d]+$/)  && sendInfo.age.match(/^[\d]+$/)) {
                $.ajax({
                    url: '/api/add',
                    type: 'PUT',
                    dataType: "json",
                    contentType: 'application/json',
                    data: JSON.stringify(sendInfo),
                    statusCode: {
                        201: function(){ $("#result").text("Contact has been successfully added!");}
                    }
                })
            }
            else{
                $("#result").text("Not valid data!");
            }

        });
    });
</script>
</head>
<body>

<h1>Contact creating</h1>

<form>
    <p><input id="name" type="text" placeholder="Name" required></p>
    <p><input id="phoneNumber" type="tel" placeholder="Phone number" required></p>
    <p><input id="age" type="number" placeholder="Age" required></p>
    <p><input id="add_contact_submit" type="submit" value="Submit"></p>
</form>

<h3 id="result"></h3>

<h4><a href="/">To main page</a> </h4>

</body>
</html>