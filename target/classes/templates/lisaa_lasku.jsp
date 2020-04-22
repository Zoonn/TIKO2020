<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>

<body>
<h2>Lisää lasku</h2>
<form>
<label for="tyokohteet">Valitse Työkohde</label>
<select id="sopimus">
    <option value="tyokohde1">tyokohde1</option>
    <option value="tyokohde2">tyokohde2</option>
</select><br>

<label for="Tarvikkeet">Valitse tarvikkeita</label>
<select id="tarvikkeet">
    <option value="tarvike1">tarvike1</option>
    <option value="tarvike2">tarvike2</option><br>
</select><br>
<table>
<tr>
    <td>tarvike1</td><td><input type="number" id="tarvike" name="tarvike1">kg</td> <td> <button type="button">Poista</button> </td>
</tr>
<tr>
    <td>tarvike2</td><td><input type="number" id="tarvike" name="tarvike2">m</td>  <td> <button type="button">Poista</button> </td>
</tr>
</table>
<br>

<label for="Valitse työn tyyppejä">Valitse työ</label>
<select id="tyot">
    <option value="Tyo1">Tyo1</option>
    <option value="Tyo2">Tyo2</option><br>
</select><br>
<table>
<tr>
    <td>Tyo1</td><td><input type="number" id="Tyo" name="Tyo2">tuntia</td> <td> <button type="button">Poista</button> </td>
</tr>
<tr>
    <td>Tyo2</td><td><input type="number" id="Tyo" name="Tyo2">tuntia</td> <td> <button type="button">Poista</button> </td>
</tr>
</table>
<br>
<input type="submit" value="Lisää">

</form>
</body>

</html> 