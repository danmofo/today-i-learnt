<#import "/layout/admin-layout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.adminLayout>
  
	<h1>Editing ${thing}</h1>

	<form action="" method="POST" role="form">
	
		<@spring.bind "thing.id" />
		<input name="${spring.status.expression}" value="${spring.status.value}" type="hidden" />

		<@spring.bind "thing.added" />
		<input name="${spring.status.expression}" value="${spring.status.value}" type="hidden" />

		<@spring.bind "thing.text" />
		<div class="form-group">
			<label for="${spring.status.expression}">Text</label>
			<input name="${spring.status.expression}" value="${spring.status.value}" type="text" class="form-control" id="${spring.status.expression}" />
			<#list spring.status.errorMessages as error> <div class="alert alert-danger">${error}</div> <br> <#else></#list>
		</div>

		<@spring.bind "thing.tags" />
		<div class="form-group">
			<label for="${spring.status.expression}">Tags</label>
			<input name="${spring.status.expression}" value="${spring.status.value}" type="text" class="form-control" id="${spring.status.expression}" />
			<#list spring.status.errorMessages as error> <div class="alert alert-danger">${error}</div> <br> <#else></#list>
		</div>
		<p>Current tag names... </p>
		<#list thing.tags as tag>
			<p>${tag.value}</p>
		</#list>

		<button type="submit" class="btn btn-lg btn-primary">Edit</button>
	</form>
	

</@layout.adminLayout>
