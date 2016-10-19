<#import "/layout/standard-layout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.standardLayout>
  
	<h1>Today I Learnt</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>text</th>
			</tr>
		</thead>
		<tbody>
			<#list things as thing>
				<tr>
					<td>${thing.id}</td>
					<td>${thing.text}</td>
				</tr>
			</#list>
		</tbody>
	</table>

</@layout.standardLayout>

