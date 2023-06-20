<#import "/spring.ftl" as spring/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Bills</title>
</head>
<body>
<div>
    <table border="3" bgcolor="#a9a9a9">
        <tr>
            <th>Client</th>
            <th>Settlements</th>
            <th>Rooms</th>
            <th>Discount</th>
            <th>TotalSum</th>
            <th>Delete</th>
        </tr>
        <#list bills as bill>
            <tr>
                <td>${bill.client.firstName}</td>
                <td><#list bill.settlements as item>
                        ${item.client.firstName}
                    </#list></td>
                <td><#list bill.rooms as item>
                        ${item}
                    </#list></td>
                <td>${bill.discount}</td>
                <td>${bill.totalSum}</td>
                <td><a href="/ui/v1/bills/${bill.id}"><button>Delete</button></a></td>
            </tr>
        </#list>
    </table>

</div>
</body>
</html>