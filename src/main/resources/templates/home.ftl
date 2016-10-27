<#import "/layout/standard-layout.ftl" as layout>
<#import "/spring.ftl" as spring />
<@layout.standardLayout>
  
	<h1>Today I Learnt</h1>

	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>text</th>
				<th>added</th>
			</tr>
		</thead>
		<tbody>
			<#list things as thing>
				<tr>
					<td>${thing.id}</td>
					<td>${thing.text}</td>
					<td>${thing.added.toDate()?datetime}</td>
				</tr>
			</#list>
		</tbody>
	</table>

</@layout.standardLayout>

