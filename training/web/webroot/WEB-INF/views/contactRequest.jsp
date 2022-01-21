<html>
<head><title>Contact Request</title></head>
<body>
<form method="post">
    <label>Sender: </label>
    <input type="text" name="newSender" value="${contactRequest.sender}"/>
    <br/>
    <label>Message:</label>
    <textarea name="newMessage">${contactRequest.message}</textarea>
    <br/>
    <input type="submit" value="Send"/>
</form>
</body>
</html>