<#-- 
	Generic pagination for Spring Data's Page<?> objects.

	Params
	---

	- page, The Page<?> object to display pagination for
	- path, The path
	
	Usage
	---

	Scenario: Displaying pagination on /tweets with a model attribute
	'tweets'.

	`<@utils.pagination page=tweets path="/tweets" />`
	
-->
<#macro pagination page path>
	<ul class="pagination">	
	
		${page.getNumber() + 1} of ${page.getTotalPages()}
			
		<#if page.hasNext()>
			<#assign next=page.nextPageable() />
			<li><a href="?page=${next.getPageNumber()}">next</a></li>
		</#if>
		
		<#if page.hasPrevious()>
			<#assign prev=page.previousPageable() />
			<#if prev.getPageNumber() == 0>
				<li><a href="${path}">prev</a></li>
				<#else>
				<li><a href="?page=${prev.getPageNumber()}">prev</a></li>
			</#if>
			
		</#if>
	</ul>
</#macro>

<#-- 
	Display a month inside a datetime object as text

	Params
	---

	- datetime, A DateTime object

-->
<#macro monthName datetime>
	${datetime.monthOfYear().getAsText()}
</#macro>