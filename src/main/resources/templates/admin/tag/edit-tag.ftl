<#import "/layout/admin-layout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.adminLayout>
  
	<h1>Editing ${tag}</h1>

	<form action="" method="POST" role="form">
	
		<@spring.bind "tag.id" />
		<input name="${spring.status.expression}" value="${spring.status.value}" type="hidden" />

		<@spring.bind "tag.value" />
		<div class="form-group">
			<label for="${spring.status.expression}">Value</label>
			<input name="${spring.status.expression}" value="${spring.status.value}" type="text" class="form-control" id="${spring.status.expression}" />
			<#list spring.status.errorMessages as error> <div class="alert alert-danger">${error}</div> <br> <#else></#list>
		</div>	
	
		<button type="submit" class="btn btn-lg btn-primary">Edit</button>
	</form>
	

</@layout.adminLayout>

