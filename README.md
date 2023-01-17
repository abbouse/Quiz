# Quiz
Simple quiz app for beginners (Kotlin)


<table>
<thead>
<tr>
<th>name</th>
<th>description</th>
<th>parameter</th>
<th>request type</th>
</tr>
</thead>
<tbody>
<tr>
<td>/addUser</td>
<td>Create new user</td>
<td><code>name</code> <code>email</code> <code>password</code></td>
<td>POST</td>
</tr>
<tr>
<td>/login</td>
<td>Authorize user</td>
<td><code>email</code> <code>password</code></td>
<td>POST</td>
</tr>
<tr>
<td>/reset</td>
<td>Forget user account</td>
<td><code>email</code></td>
<td>POST</td>
</tr>
<tr>
<td>/createNote</td>
<td>Create new note</td>
<td><code>user_id</code> <code>heading</code>  <code>note</code></td>
<td>POST</td>
</tr>
<tr>
<td>/getNotes</td>
<td>Get all notes by user</td>
<td><code>id</code></td>
<td>GET</td>
</tr>
<tr>
<td>/getuser</td>
<td>Get user information</td>
<td><code>id</code></td>
<td>GET</td>
</tr>
<tr>
<td>/updateUser</td>
<td>Update user information</td>
<td><code>id</code> <code>name</code> <code>email</code></td>
<td>POST</td>
</tr>
<tr>
<td>/updatePass</td>
<td>Update user</td>
<td><code>id</code> <code>cpassword</code> <code>password</code></td>
<td>POST</td>
</tr>
</tbody>
</table>
