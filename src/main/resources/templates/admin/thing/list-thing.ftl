<#import "/layout/admin-layout.ftl" as layout>
<#import "/spring.ftl" as spring />
<#import "/common/utils.ftl" as utils />
<@layout.adminLayout>
  
<h1>Listing all things</h1>

<table class="table table-striped">
	<thead>
		<tr>
			<th>id</th>
			<th>text</th>
			<th>added</th>
			<th>tags</th>
			<th>actions</th>
		</tr>
	</thead>
	<tbody>
		${things}
		<#list things.getContent() as thing>
			<tr>
				<td>${thing.id}</td>
				<td>${thing.text}</td>
				<td>${thing.added}</td>
				<td></td>
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
	<@utils.pagination page=things path="/admin/thing/list" />
	<a href="/admin/thing/add" class="btn btn-primary btn-lg">Add new</a>
</div>

</@layout.adminLayout>