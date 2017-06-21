<!DOCTYPE html>

<html lang="en">

<body>
Date: ${time?date}
<br>
<#--遍历-->
<#list ["克里斯埃文斯", "斯嘉丽约翰逊", "小罗伯特唐尼"]  as x>
${x}
</#list>
<br>
<#--判断-->
<#if x = 1>
x is 1
<#else>
x is not 1
</#if>
<br>
</body>

</html>