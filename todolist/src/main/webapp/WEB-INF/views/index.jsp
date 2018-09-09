<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    function createItems() {
        $.ajax('./json', {
            method: 'get',
            complete: function (data) {
                console.log(JSON.parse(data.responseText));
                var result = "<tr>" +
                    "           <th>Description</th>" +
                    "           <th>Date</th>" +
                    "      </tr>";
                var items = JSON.parse(data.responseText);
                for (var i = 0; i != items.length; ++i) {
                    if (document.getElementById("check").checked) { if (items[i].done == true) {
                        result += "<tr>" +
                            "           <td>" + items[i].desc + "</td>" +
                            "           <td>" + items[i].created + "</td>" +
                            "      </tr>";
                    } } else {
                        result += "<tr>" +
                            "           <td>" + items[i].desc + "</td>" +
                            "           <td>" + items[i].created + "</td>" +
                            "      </tr>";
                    }
                }
                var table = document.getElementById("items");
                table.innerHTML = result;
            }
        })
        return false;
    }

    function validate() {
        var valid = true;
        if (document.getElementById("item").value == '') {
            alert('Заполните поле item');
            valid = false;
        }
        return valid;
    }
</script>
</head>
<body>
<form class="form-inline" action="${pageContext.servletContext.contextPath}/" method="post" name="contact_form">
    <div class="form-group">
        <label for="item">Description:</label>
        <textarea class="form-control" rows="1" id="item" name="item"></textarea>
        <input type="submit" name="submit" value="create item" class="btn btn-primary" onclick="validate()"/>
    </div>
</form>
<form class="form-inline">
    <div class="form-group">
        <label><input type="checkbox" id="check" name="checkbox" value="true">Done</label>
        <input type="submit" name="submit" value="Show all items" class="btn btn-primary" onclick="return createItems();"/>
    </div>
</form>
<div class="form-group">
    <table id="items" class="table table-bordered">
    </table>
</div>
</body>
</html>
