$(function(){
    $.ajax({
        url:'http://localhost:8080/employee/employees',
         data: { format: 'json'},
        error: function(){
          console.log('not found');
        },
        success : showEmployees,
        dataType: "jsonp",
        jsonpCallback: 'showEmployees',
        contentType: 'application/json',
        crossDomain: true,
        type: 'GET'

    });

    function showEmployees(data){
        for(i=0;i<data.name.length;i++){
            $("#selectEmp")
            .append($("<option></option>")
            .attr("value",data.name[i])
            .text(data.name[i])); 
        }
    }

$("#selectEmp").change(function(){
    $.ajax({
        url:'http://localhost:8080/employee/'+ $(this).val(),
         data: { format: 'json'},
        error: function(){
          console.log('not found');
        },
        success : showSalary,
        dataType: "jsonp",
        jsonpCallback: 'showSalary',
        contentType: 'application/json',
        crossDomain: true,
        type: 'GET'


        });

        function showSalary(data){
            console.log(data);
            $("#salary").html('Salary: '+data.salary +'€');
        }
   
    });

    


});