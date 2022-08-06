<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FLASH CARD</title>
<link rel="styleSheet" type="text/css"
	href="${pageContext.request.contextPath}/css/EvenTable.css">
<%-- <link rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.0/css/bootstrap.min.css"> --%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 	<div class="container" style="background-color: cyan;">
		<div></div>

	</div> -->



	<div class="container" style="background-color: yellow;">
		<form class="form-inline">
			<div class="form-group">
				<label for="mail">Mail</label>
				<input type="email" class="form-control" id="mail">
			</div>
			<div class="form-group">
				<label for="password">Pass</label>
				<input type="password" class="form-control" id="password">
			</div>
			<button type="submit" class="btn btn-default">Send</button>
		</form>

	</div>

	<div class="container" style="background-color: cyan;">
		<form>
			<fieldset>
				<legend>Legend</legend>
				<div class="form-group row">
					<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="text" readonly="" class="form-control-plaintext"
							id="staticEmail" value="email@example.com">
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1" class="form-label mt-4">Email
						address</label>
					<input type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Enter email">
					<small id="emailHelp" class="form-text text-muted">We'll
						never share your email with anyone else.</small>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1" class="form-label mt-4">Password</label>
					<input type="password" class="form-control"
						id="exampleInputPassword1" placeholder="Password">
				</div>
				<div class="form-group">
					<label for="exampleSelect1" class="form-label mt-4">Example
						select</label> <select class="form-select" id="exampleSelect1">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div>
				<div class="form-group">
					<label for="exampleSelect2" class="form-label mt-4">Example
						multiple select</label> <select multiple="" class="form-select"
						id="exampleSelect2">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div>
				<div class="form-group">
					<label for="exampleTextarea" class="form-label mt-4">Example
						textarea</label>
					<textarea class="form-control" id="exampleTextarea" rows="3"></textarea>
				</div>
				<div class="form-group">
					<label for="formFile" class="form-label mt-4">Default file
						input example</label>
					<input class="form-control" type="file" id="formFile">
				</div>
				<fieldset class="form-group">
					<legend class="mt-4">Radio buttons</legend>
					<div class="form-check">
						<label class="form-check-label"> <input type="radio"
								class="form-check-input" name="optionsRadios"
								id="optionsRadios1" value="option1" checked=""> Option
							one is this and that—be sure to include why it's great
						</label>
					</div>
					<div class="form-check">
						<label class="form-check-label"> <input type="radio"
								class="form-check-input" name="optionsRadios"
								id="optionsRadios2" value="option2"> Option two can be
							something else and selecting it will deselect option one
						</label>
					</div>
					<div class="form-check disabled">
						<label class="form-check-label"> <input type="radio"
								class="form-check-input" name="optionsRadios"
								id="optionsRadios3" value="option3" disabled=""> Option
							three is disabled
						</label>
					</div>
				</fieldset>
				<fieldset class="form-group">
					<legend class="mt-4">Checkboxes</legend>
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""
							id="flexCheckDefault">
						<label class="form-check-label" for="flexCheckDefault">
							Default checkbox </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="checkbox" value=""
							id="flexCheckChecked" checked="">
						<label class="form-check-label" for="flexCheckChecked">
							Checked checkbox </label>
					</div>
				</fieldset>
				<fieldset>
					<legend class="mt-4">Switches</legend>
					<div class="form-check form-switch">
						<input class="form-check-input" type="checkbox"
							id="flexSwitchCheckDefault">
						<label class="form-check-label" for="flexSwitchCheckDefault">Default
							switch checkbox input</label>
					</div>
					<div class="form-check form-switch">
						<input class="form-check-input" type="checkbox"
							id="flexSwitchCheckChecked" checked="">
						<label class="form-check-label" for="flexSwitchCheckChecked">Checked
							switch checkbox input</label>
					</div>
				</fieldset>
				<fieldset class="form-group">
					<legend class="mt-4">Ranges</legend>
					<label for="customRange1" class="form-label">Example range</label>
					<input type="range" class="form-range" id="customRange1">
					<label for="disabledRange" class="form-label">Disabled
						range</label>
					<input type="range" class="form-range" id="disabledRange"
						disabled="">
					<label for="customRange3" class="form-label">Example range</label>
					<input type="range" class="form-range" min="0" max="5" step="0.5"
						id="customRange3">
				</fieldset>
				<button type="submit" class="btn btn-primary">Submit</button>
			</fieldset>
		</form>

	</div>


	<div class="container table-responsive"
		style="background-color: orange;">
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>Name</th>
					<th>address</th>
					<th>email</th>
					<th>phone</th>
					<th>dept</th>
				</tr>
			</thead>
			<tbody>
				<tr class="table-danger">
					<td>01</td>
					<td>Jim</td>
					<td>xxx</td>
					<td>xxx</td>
					<td>xxx</td>
					<td>xxx</td>
				</tr>
				<tr class="table-info">
					<td>02</td>
					<td>Tom</td>
					<td>xxx</td>
					<td>xxx</td>
					<td>xxx</td>
					<td>xxx</td>
				</tr>
				<tr>
					<td>03</td>
					<td>Helen</td>
					<td>xxx</td>
					<td>xxx</td>
					<td>xxx</td>
					<td>xxx</td>
				</tr>
				<tr>
					<td>04</td>
					<td>John</td>
					<td>xxx</td>
					<td>xxx</td>
					<td>xxx</td>
					<td>xxx</td>
				</tr>
				<tr>
					<td>05</td>
					<td>Peter</td>
					<td>xxx</td>
					<td>xxx</td>
					<td>xxx</td>
					<td>xxx</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="container" style="background-color: cyan;">
		<table class="table table-borderd">
			<thead>
				<tr>
					<th>No.</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>01</td>
					<td>Jim</td>
				</tr>
				<tr>
					<td>02</td>
					<td>Tom</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="container" style="background-color: orange;">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Type</th>
					<th scope="col">Column heading</th>
					<th scope="col">Column heading</th>
					<th scope="col">Column heading</th>
				</tr>
			</thead>
			<tbody>
				<tr class="table-active">
					<th scope="row">Active</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr>
					<th scope="row">Default</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr class="table-primary">
					<th scope="row">Primary</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr class="table-secondary">
					<th scope="row">Secondary</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr class="table-success">
					<th scope="row">Success</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr class="table-danger">
					<th scope="row">Danger</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr class="table-warning">
					<th scope="row">Warning</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr class="table-info">
					<th scope="row">Info</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr class="table-light">
					<th scope="row">Light</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
				<tr class="table-dark">
					<th scope="row">Dark</th>
					<td>Column content</td>
					<td>Column content</td>
					<td>Column content</td>
				</tr>
			</tbody>
		</table>

	</div>

	<div class="container" style="background-color: cyan;">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active"
				data-bs-toggle="tab" href="#home">Home</a></li>
			<li class="nav-item"><a class="nav-link" data-bs-toggle="tab"
				href="#profile">Profile</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
			</li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a> <a
						class="dropdown-item" href="#">Something else here</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Separated link</a>
				</div></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade show active" id="home">
				<p>Raw denim you probably haven't heard of them jean shorts
					Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse.
					Mustache cliche tempor, williamsburg carles vegan helvetica.
					Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby
					sweater eu banh mi, qui irure terry richardson ex squid. Aliquip
					placeat salvia cillum iphone. Seitan aliquip quis cardigan american
					apparel, butcher voluptate nisi qui.</p>
			</div>
			<div class="tab-pane fade" id="profile">
				<p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla
					single-origin coffee squid. Exercitation +1 labore velit, blog
					sartorial PBR leggings next level wes anderson artisan four loko
					farm-to-table craft beer twee. Qui photo booth letterpress, commodo
					enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum
					PBR. Homo nostrud organic, assumenda labore aesthetic magna
					delectus mollit.</p>
			</div>
			<div class="tab-pane fade" id="dropdown1">
				<p>Etsy mixtape wayfarers, ethical wes anderson tofu before they
					sold out mcsweeney's organic lomo retro fanny pack lo-fi
					farm-to-table readymade. Messenger bag gentrify pitchfork tattooed
					craft beer, iphone skateboard locavore carles etsy salvia banksy
					hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify
					squid 8-bit cred pitchfork.</p>
			</div>
			<div class="tab-pane fade" id="dropdown2">
				<p>Trust fund seitan letterpress, keytar raw denim keffiyeh etsy
					art party before they sold out master cleanse gluten-free squid
					scenester freegan cosby sweater. Fanny pack portland seitan DIY,
					art party locavore wolf cliche high life echo park Austin. Cred
					vinyl keffiyeh DIY salvia PBR, banh mi before they sold out
					farm-to-table VHS viral locavore cosby sweater.</p>
			</div>
		</div>

	</div>




	<div>
		<button type="button" class="btn btn-primary">Primary</button>
		<button type="button" class="btn btn-secondary">Secondary</button>
		<button type="button" class="btn btn-success">Success</button>
		<button type="button" class="btn btn-info">Info</button>
		<button type="button" class="btn btn-warning">Warning</button>
		<button type="button" class="btn btn-danger">Danger</button>
		<button type="button" class="btn btn-light">Light</button>
		<button type="button" class="btn btn-dark">Dark</button>
		<button type="button" class="btn btn-link">Link</button>
	</div>


	<div class="btn-toolbar" role="toolbar"
		aria-label="Toolbar with button groups">
		<div class="btn-group me-2" role="group" aria-label="First group">
			<button type="button" class="btn btn-secondary">1</button>
			<button type="button" class="btn btn-secondary">2</button>
			<button type="button" class="btn btn-secondary">3</button>
			<button type="button" class="btn btn-secondary">4</button>
		</div>
		<div class="btn-group me-2" role="group" aria-label="Second group">
			<button type="button" class="btn btn-secondary">5</button>
			<button type="button" class="btn btn-secondary">6</button>
			<button type="button" class="btn btn-secondary">7</button>
		</div>
		<div class="btn-group" role="group" aria-label="Third group">
			<button type="button" class="btn btn-secondary">8</button>
		</div>
	</div>

	<div style="background-color: cyan;" class="container">
		<img alt="xxx"
			src="${pageContext.request.contextPath}/picture/wagasa-512.png"
			class="img-responsive">
	</div>

	<div style="background-color: orange;" class="container">
		<p>
			P1
			<code>xx</code>
			end
		</p>
		<p>
			P1
			<kbd>xxx</kbd>
			end
		</p>
		<p>
			<var>f(x)</var>
			= a
			<var>x</var>
			+b
		</p>
		<p>
			<samp>System.out.println(new java.util.Date())</samp>
		</p>
		<p>System.out.println(new java.util.Date())</p>

		<pre>
		logger.info("service=" + vocabularyService);
		List&lt;Vocabulary&gt; allVocabulary = vocabularyService.getAllVocabulary();
		// System.out.println(user.getUserName());  
		// logger.info("值："+user.getUserName());  
		logger.info(JSON.toJSONString(allVocabulary));


		</pre>


	</div>


	<div style="background-color: yellow;" class="container">
		<p>P1</p>
		<p class="lead">P2</p>
		<p class="text-left">P3-1</p>
		<p class="text-center">P3-2</p>
		<p class="text-right">P3-3</p>
		<p class="text-justify">P3-4</p>
		<p class="text-nowrap">P3-5</p>
		<hr>
	</div>

	<div style="background-color: cyan;" class="container">


		<div class="row">
			<div class="col-md-1">1-1</div>
			<div class="col-md-1">1-2</div>
			<div class="col-md-1">1-3</div>
			<div class="col-md-1">1-4</div>
			<div class="col-md-1">1-5</div>
			<div class="col-md-1">1-6</div>

		</div>
		<div style="background-color: orange;" class="row">
			<div class="col-md-3">2-1</div>
			<div class="col-md-3">2-2</div>

		</div>

		<div style="background-color: yellow;" class="row">
			<div class="col-md-1">3-1</div>
			<div class="col-md-2">3-2</div>
			<div class="col-md-3">3-3</div>

		</div>



	</div>

	<div class="container-fluid">
		<div style="background-color: orange;" class="row">
			<div class="col-sm-4">區塊 1</div>
			<div class="col-sm-4 col-sm-offset-4">區塊 2</div>

		</div>
		<div style="background-color: yellow;" class="row">
			<div class="col-sm-4 col-sm-offset-1">區塊 3</div>
			<div class="col-sm-4 ">區塊 4</div>

		</div>

	</div>


</body>
</html>