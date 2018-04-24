<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head> 
   
     <title>CRUD Products Project</title>  
     
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">    
     
	 <!--Import Google Icon Font-->
     <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">   
     
     <!--Import materialize.css-->  
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
     
  </head>
  <body ng-app="myApp" class="ng-cloak">
  
      
  	   <div class="navbar-fixed">
  	 
			  <nav class = "nav teal">
			  
				    <div class="nav-wrapper">
				    
				      <a href="http://localhost:8080/" class="brand-logo">
				      
			             <i class="material-icons">
					        storage
					     </i>
					     
					     CRUD Products Project
					     
				      </a>
				      <ul id="nav-mobile" class="right hide-on-med-and-down">
				        <li><a href="http://localhost:8080/">Home</a></li>
				      </ul>
				      
				    </div>
			    
			  </nav>  
		  
	  </div>
  
      <div class=container" ng-controller="ProductController as ctrl">
      
          <div class = "row">
          
          		<div class = "col s4 offset-2">
          		     
          		      <div class = "card-panel teal lighten-1">
          		      
          		           <h4 class = "center white-text"> Product Registration/Edit </h4>
          		           
          		      </div>
          		     
	                  <form ng-submit="ctrl.submit()" name="myForm" >
                  
                      		  <input type="hidden" ng-model="ctrl.product.id" />
                      
		                      <div class="form-group">	  
		                      		                      
		                            <img src="#" alt="" style="width: 200px; height: 200px;" >   
									
								    <div class="file-field input-field">
								    
								      <div class="btn">
								      
								        <span>Load image</span>
								        <input type="file" ng-model="ctrl.product.image" #Image accept = "image/*"/>
								        
								      </div>
								      
								      <div class="file-path-wrapper">
								      
								        <input class="file-path validate" type="text">
								        
								      </div>
								      
								    </div>														 
								  
							</div> 
					                      
	                          <div class="input-field">
	                          				                             
                                  <textarea ng-model="ctrl.product.description" class="materialize-textarea" placeholder="Product description"></textarea>	                                  
	                              <label for="file">Description</label>				                                
	                              
	                          </div>
					                          
	                          <div class="row">
	                          
			                          <div class="input-field col s6">
			                          
			                              <input type="date" class="form-control input-sm" name="input" ng-model="ctrl.product.date" value = " {{ctrl.product.date }} "/> 
			                              <label for="file">Date</label>												      
									      						                              
			                          </div>										                          	
			                          					                          
			                          <div class="form-group col s6">
			                          
											<label for="file">
											       Origen
											       <select class = "form-control" ng-model="ctrl.product.origen" ng-options="c for c in ctrl.origens"></select>	
											</label>
			                            
			                          </div>	
	                          
	                          </div>
	                          							                          
			                          
	                          <div class="input-field">	    
	                          
						          <input type="text" id="autocomplete-input" ng-model="ctrl.product.category" class="autocomplete" placeholder="Product category">
						          <label for="autocomplete-input">Category</label>   
						          
	                          </div>		                          
	                          
	                          <div class="row">	
	                          
		                           <div class="form-group col s3">
		                          
										<label for="file">
										       Coin
										       <select class = "form-control" ng-model="ctrl.product.coin" ng-options="p for p in ctrl.coins"></select>	
										</label>
		                            
		                          </div>	
		                          	                          
				                  <div class="input-field  col s3">   
				                       							
	                                  <input type="text" ng-model="ctrl.product.price" placeholder="Product price" />							                    
		                              <label for="file">Price</label>
		                              
	                              </div>
				                              
		                      </div>				  
							 
					                          
		                      <div class="form-actions center">
		                      
		                          <a type="button"  ng-click="ctrl.submit()" class="btn-floating btn-large waves-effect waves-light green" ng-disabled="myForm.$invalid">
		                             <i class="material-icons">
		                                check
		                             </i>
		                          </a>
		                          
		                          <button type="button" ng-click="ctrl.reset()" class="btn-floating btn-large waves-effect waves-light red" ng-disabled="myForm.$pristine">
		                          
		                             <i class="material-icons">
		                                replay
		                             </i>	
		                             	                          
		                          </button>
		                      
		                      </div>	    

                  	  </form>          		     
          		
          		</div>
          
                
              <div class = "col s8 offset-2">
              
          		      <div class = "card-panel teal lighten-1">
          		      
          		           <h4 class = "center white-text"> List of Products  </h4>
          		           
          		      </div> 
          		      

					  <ul class="collection" ng-repeat="u in ctrl.products">
					  	  
							    <li class="collection-item avatar">
							    
							      <img src="#" alt="" class="circle">

							      <div class = "col s3 offset-2">
							      
							         <a>Id </a> <span ng-bind="u.id"></span>							         
							         <br>
							         <a>Date: </a> <span ng-bind="u.date"></span>
							         <br>
							         <a>Price (R$): </a> <span ng-bind="u.pricer" ></span>
							         <br>
							         <a>Price (U$D): </a> <span ng-bind="u.priced"></span>	
							         
							      </div>
							      
							      <div class = "col s9 offset-2">
							      
							         <a>Description: </a> <span ng-bind="u.description"></span>
							         <br>
							         <a>Origen: </a> <span ng-bind="u.origen"></span>
							         <br>
							         <a>Category: </a> <span ng-bind="u.category"></span>
							         
							      </div>										      
							      
							      <div class="secondary-content">
							      
			                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn-floating btn-small waves-effect waves-light green">
				                              
			                              		  <i class="material-icons">
							                          edit
							                      </i>
								                      
				                          </button>  
				                              
			                              <button type="button" ng-click="ctrl.remove(u.id)" class="btn-floating btn-small waves-effect waves-light red">
			                              
			                              		  <i class="material-icons">
							                          delete
							                      </i>
							                      
			                              </button>
	                              
	                              </div>
	                              
							      
							    </li>
					    
					  </ul>          
          		               
              </div>
              

          </div>
          
      </div>
      

        <footer class="page-footer grey  lighten-1" >
        
          <div class="container">
          
            <div class="row">
            
              <div class="col l6 s12">
              
                <h5 class="white-text">Contact</h5>
                <p class="grey-text text-lighten-4">Alejandro Toledo González</p>
                
              </div>
              
              <div class="col l4 offset-l2 s12">
              
                <h5 class="white-text">Mail</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="mailto: alejandrotg146@gmail.com">alejandrotg146@gmail.com</a></li>
                </ul>
                
              </div>
              
            </div>
            
          </div>
          
          <div class="footer-copyright">
          
            <div class="container center">
            
                  <h6>Created by Alejandro Toledo González - 2018</h6>
            
            </div>
            
          </div>
          
        </footer>      
      
	  <!-- JavaScript for: jQuery, angular, materialize, and angular-materialize. All of which are needed. -->
	  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
      
      <script src="<c:url value='js/app.js' />"></script>
      <script src="<c:url value='js/service/product_service.js' />"></script>
      <script src="<c:url value='js/controller/product_controller.js' />"></script>
      
      
  </body>
  
  
</html>