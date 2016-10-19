<#import "/layout/admin-layout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.adminLayout>
  
<h1>List</h1>

<table class="table table-striped">
	<thead>
		<tr>
			<th>id</th>
			<th>text</th>
			<th>added</th>
			<th>actions</th>
		</tr>
	</thead>
	<tbody>
		<#list things as thing>
			<tr>
				<td>${thing.id}</td>
				<td>${thing.text}</td>
				<td>${thing.added}</td>
				<td>
					<a href="/admin/thing/edit/${thing.id}" class="btn btn-primary">Edit</a>	
					<form action="/admin/thing/delete" method="POST">
						<input name="id" value="${thing.id}" type="hidden" />
						<button type="submit" class="btn btn-danger">Delete</a>	
					</form>
				</td>
			</tr>
		</#list>
	</tbody>
</table>
<div class="pull-right">
	<a href="/admin/thing/add" class="btn btn-primary btn-lg">Add new</a>
</div>

</@layout.adminLayout>

