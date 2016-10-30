<#import "/layout/standard-layout.ftl" as layout>
<#import "/spring.ftl" as spring />
<#import "/calendar/views.ftl" as views />
<@layout.standardLayout>
   
 	<@views.calendarMonth monthlyThings=monthlyThings />
 	
</@layout.standardLayout>