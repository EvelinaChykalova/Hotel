<#import "/spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Settlements</title>
</head>
<body>
<div>
    <table border="3" bgcolor="#a9a9a9">
        <tr>
            <th>Client</th>
            <th>Room</th>
            <th>DateOfSettlement</th>
            <th>DateOfEviction</th>
            <th>Note</th>
            <th>Delete</th>
        </tr>
        <#list settlements as settlement>
            <tr>
                <td>${settlement.client}</td>
                <td>${settlement.room}</td>
                <td>${settlement.dateOfSettlement}</td>
                <td>${settlement.dateOfEviction}</td>
                <td>${settlement.note}</td>
                <td><a href="/ui/v1/settlements/${settlement.id}"><button>Delete</button></a></td>
            </tr>
        </#list>
    </table>

</div>
</body>
</html>