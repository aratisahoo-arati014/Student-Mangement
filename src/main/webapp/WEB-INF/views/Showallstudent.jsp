<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show all Student</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="modal fade" id="deletePopup" tabindex="-1" aria-labelledby="deletePopupLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="deletePopupLabel">Deleting...</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Are you sure to delete the Student permanently?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <form action="delete" method="post" name="form">
        <input type="hidden" name="idtodelete" value="">
        <button type="button" class="btn btn-primary" id="confirmDeleteBtn" onclick="confirmDelete()">Yes</button>
        </form>
      </div>
    </div>
  </div>
</div><br>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">SMS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="home">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="add">Add</a></li>
					<li class="nav-item"><a class="nav-link active" href="#">All</a>
					</li>
				</ul>

			</div>
		</div>
	</nav>
	<br>
	
	<c:choose>
				<c:when test="${stuid ne null and stuid ne 0}">
					<c:if
						test="${successmsg ne null and not empty successmsg}">
						<div class="alert alert-success" role="alert">
							<c:out value='${successmsg}' />
						</div>
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if
						test="${failuremsg ne null and not empty failuremsg}">
						<div class="alert alert-danger" role="alert">
							<c:out value='${failuremsg}' />
						</div>
					</c:if>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${updatecount ne null and updatecount ne 0}">
					<c:if
						test="${updated ne null and not empty updated}">
						<div class="alert alert-success" role="alert">
							<c:out value='${updated}' />
						</div>
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if
						test="${notupdated ne null and not empty notupdated}">
						<div class="alert alert-danger" role="alert">
							<c:out value='${notupdated}' />
						</div>
					</c:if>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${deletecount ne null and deletecount ne 0}">
					<c:if
						test="${deleted ne null and not empty deleted}">
						<div class="alert alert-success" role="alert">
							<c:out value='${deleted}' />
						</div>
					</c:if>
				</c:when>
				<c:otherwise>
					<c:if
						test="${notdeleted ne null and not empty notdeleted}">
						<div class="alert alert-danger" role="alert">
							<c:out value='${notdeleted}' />
						</div>
					</c:if>
				</c:otherwise>
			</c:choose>
			
<div class="card border-info mb-3">
	<div class="card-body">
		<table
			class="table table-hover caption-top table-bordered border-secondary">
			<caption>List of Student</caption>

			<thead>
				<tr>
					<td colspan="6">
						<div class="d-flex justify-content-end">
							<a class="btn btn-primary me-2" onclick="updateStudent()" href="#" role="button">Update</a>
							<a class="btn btn-primary" onclick="deleteStudent()" href="#" role="button">Delete</a>
						
						</div>
					</td>
				</tr>
				<tr>
					<th></th>
					<th>ID</th>
					<th>FirstName</th>
					<th>LastEmail</th>
					<th>Email</th>
					<th>mobile_no</th>
					<th>Dept</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty employeeList}">
						<tr>
							<td colspan="6">No employees found.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr></tr>
						<c:forEach items="${employeeList}" var="employee">
							<tr>
								<td align="center"><input type="checkbox" class="employee-checkbox"
									value="${student.id}" style="align: middle" onclick="handleCheckboxClick(this)"></td>
								<td>${student.id}</td>
								<td>${student.firstname}</td>
								<td>${student.lastname}</td>
								<td>${student.email}</td>
								<td>${student.mobile_no}</td>
								<td>${student.dept}</td>	
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		</div>
	</div>
</body>

<script>
function handleCheckboxClick(clickedCheckbox) {
    var checkboxes = document.querySelectorAll('.student-checkbox');
    checkboxes.forEach(function(checkbox) {
        if (checkbox !== clickedCheckbox) {
            checkbox.checked = false;
        }
    });
}


function deleteStudent() {
    var checkedCheckbox = document.querySelector('.student-checkbox:checked');
    if (checkedCheckbox) {
    	$('#deletePopup').modal('show');
        
    } else {
        console.log("No employee selected for deletion.");
    }
}

function confirmDelete(){
	var checkedCheckbox = document.querySelector('.student-checkbox:checked');
	if (checkedCheckbox) {
		document.form.idtodelete.value=checkedCheckbox.value;
		document.form.submit();
	}
}

function updateStudent() {
    var checkedCheckbox = document.querySelector('.student-checkbox:checked');
    if (checkedCheckbox) {
        var updateUrl = 'getstu?id=' + checkedCheckbox.value;
        //var updateUrl = 'getEmp/' + checkedCheckbox.value;
        window.location.href = updateUrl;
    } else {
        console.log("No student selected for update.");
    }
}
</script>

</html>