<#import "/common/utils.ftl" as utils />
<#macro calendarMonth monthlyThings>
	<#-- Helper variables -->
	<#assign previousMonth=monthlyThings.getPreviousMonth() />
	<#assign nextMonth=monthlyThings.getNextMonth() />
	<#assign previousYear=monthlyThings.getPreviousYear() />
	<#assign nextYear=monthlyThings.getNextYear() />

	<#-- Previous / next month navigation -->
	<div class="row">
		<div class="col-sm-2">
			<a href="/calendar/${previousMonth.year().get()?c}/${previousMonth.monthOfYear().get()}">&laquo;<@utils.monthName datetime=previousMonth /></a>
		</div>
		<div class="col-sm-8">
			<h1 class="text-center"><@utils.monthName datetime=monthlyThings.getMonth() /> (${monthlyThings.getMonth().year().get()?c}) - ${monthlyThings.getThingCount()} Thing objects!</h1>
		</div>
		<div class="col-sm-2">
			<a href="/calendar/${nextMonth.year().get()?c}/${nextMonth.monthOfYear().get()}"><@utils.monthName datetime=monthlyThings.getNextMonth() />&raquo;</a>
		</div>
	</div>

	<#-- The calendar -->
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Monday</th>
				<th>Tuesday</th>
				<th>Wednesday</th>
				<th>Thursday</th>
				<th>Friday</th>
				<th>Saturday</th>
				<th>Sunday</th>
			</tr>
		</thead>
		<tbody>
			<#list monthlyThings.getThings() as day, things>
				<#-- Start weekly row -->
				<#if day?counter % 7 == 1>
					<tr>
				</#if>
				<#if day gt 0>
					<#if things??>
						<#if things?size gte 3>
							<td class="success">
						<#elseif things?size gte 2>
							<td class="warning">
						<#elseif things?size gte 1>
							<td class="info">
						<#else />
							<td>
						</#if>
					<#else />
					</#if>
						<strong>${day}</strong>
						<ul>
							<#if things??>
								<#if things?size gt 0>
									${things?size} Things!
								</#if>
							</#if>
						</ul>
					</td>
					<#else />
					<#-- Days that belong to previous / next months -->
					<td class="disabled">
						${day?abs}
					</td>
				</#if>
				<#-- End weekly row -->
				<#if day?counter % 7 == 0>
					</tr>
				</#if>
			</#list>
		</tbody>
	</table>
</#macro>