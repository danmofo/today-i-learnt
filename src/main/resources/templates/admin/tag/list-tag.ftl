<#import "/layout/admin-layout.ftl" as layout>
<#import "/spring.ftl" as spring />
<#import "/common/utils.ftl" as utils />
<@layout.adminLayout>
  
<h1>Listing all tags</h1>

<table class="table table-striped">
	<thead>
		<tr>
			<th>id</th>
			<th>value</th>
			<th>actions</th>
		</tr>
	</thead>
	<tbody>
		<#list tags.getContent() as tag>
			<tr>
				<td>${tag.id}</td>
				<td>${tag.value}</td>
				<td>
					<a href="/admin/tag/edit/${tag.id}" class="btn btn-primary">Edit</a>	
					<form action="/admin/tag/delete" method="POST">
						<input name="id" value="${tag.id}" type="hidden" />
						<button type="submit" class="btn btn-danger">Delete</a>	
					</form>
				</td>
			</tr>
		</#list>
	</tbody>
</table>
<div class="pull-right">
	<@utils.pagination page=tags path="/admin/tag/list" />
	<a href="/admin/tag/add" class="btn btn-primary btn-lg">Add new</a>
</div>

</@layout.adminLayout>

