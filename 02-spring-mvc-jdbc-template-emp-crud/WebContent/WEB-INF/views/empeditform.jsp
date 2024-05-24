<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Employee</h1>  
       <form:form method="POST" action="/editsave">    
        <table >    
        <tr>     
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>First Name : </td>   
          <td><form:input path=""  /></td>  
         </tr>    
         <tr>    
          <td>Last Name :</td>    
          <td><form:input path="" /></td>  
         </tr>   
         <tr>    
          <td>Email :</td>    
          <td><form:input path="" /></td>  
         </tr>  
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    