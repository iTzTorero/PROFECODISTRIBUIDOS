<%-- 
    Document   : ofertasMercado
    Created on : 6/05/2022, 09:23:02 AM
    Author     : crist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Procuraduría Federal del Consumidor</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="icon/1.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <!-- body -->
    <body class="main-layout">
        <!-- loader  -->
        <div class="loader_bg">
            <div class="loader"><img src="images/loading.gif" alt="#" /></div>
        </div>
        <!-- end loader --> 
        <!-- header -->
        <header>
            <!-- header inner -->
            <div class="header">
                <div class="head_top">
                    <div class="container">
                        <div class="row">
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                <div class="top-box">
                                    <ul class="sociel_link">
                                        <li> <img src="images/logogobierno.png" alt=""/></li>


                                    </ul>
                                </div>
                            </div>
                            <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                <div class="top-box">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <a name = "inicio"></a>
                    <div class="row">
                        <div class="col-sm-3 col-md-6 col-lg-4 col-xl-2 logo_section">
                            <div class="full">
                                <div class="center-desk">



                                </div>
                            </div>
                        </div>
                        <div class="col-xl-7 col-lg-7 col-md-9 col-sm-9">
                            <div class="menu-area">
                                <div class="limit-box">
                                    <nav class="main-menu">
                                        <ul class="menu-area-main">
                                            <li class="active"> <a href="indexMercado.jsp">Inicio</a> </li>
                                            <li> <a href="ofertasMercado.jsp">Ofertas</a> </li>
                                            <li> <a href="administra.jsp">Administra</a> </li>
                                            <li> <a href="publicaOferta.jsp">Publica oferta</a> </li>    



                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-2 col-lg-2 col-md-2 col-sm-2">
                            <li><a class="buy" href="index.jsp">Salir</a></li>
                        </div>
                    </div>
                </div>
                <!-- end header inner --> 
        </header>
        <!-- end header -->
        <section class="slider_section">
            <div id="main_slider" class="carousel slide banner-main" data-ride="carousel">

                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="first-slide" src="images/banner2.jpg" alt="First slide">

                    </div>



                </div>
                <a class="carousel-control-prev" href="#main_slider" role="button" data-slide="prev">
                    <i class='fa fa-angle-right'></i>
                </a>
                <a class="carousel-control-next" href="#main_slider" role="button" data-slide="next">
                    <i class='fa fa-angle-left'></i>
                </a>

            </div>

        </section>



        <div class="brand_color">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="titlepage">
                            <h2>Ofertas</h2>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-- Lastestnews -->
        <div class="Lastestnews blog">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="titlepage">

                            <span>¡Encuentra los mejores productos a los mejores precios!</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 margin">
                        <div class="news-box">
                            <figure><img src="images/1.jpg" alt="img" /></figure>
                            <h3>Días de Festejar a Mamá</h3>
                            <span>Mayo 10</span><br>
                            <button type="button" class="buy2" data-bs-toggle="modal" data-bs-target="#myModal">Eliminar</button><br><br><br><br>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 margin">
                        <div class="news-box">
                            <figure><img src="images/2.jpg" alt="img" /></figure>
                            <h3>Laptop 4GB RAM 128GB</h3>
                            <span>Mayo 15</span><br>
                            <button type="button" class="buy2" data-bs-toggle="modal" data-bs-target="#myModal">Eliminar</button><br><br><br><br>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 margin">
                        <div class="news-box">
                            <figure><img src="images/3.jpg" alt="img" /></figure>
                            <h3>Rebajas en Pantallas</h3>
                            <span>Mayo 15</span><br>
                            <button type="button" class="buy2" data-bs-toggle="modal" data-bs-target="#myModal">Eliminar</button><br><br><br><br>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
                        <div class="news-box">
                            <figure><img src="images/3.jpg" alt="img" /></figure>
                            <h3>Rebajas en Pantallas</h3>
                            <span>Mayo 15</span><br>
                            <button type="button" class="buy2" data-bs-toggle="modal" data-bs-target="#myModal">Eliminar</button><br><br><br><br>
                        </div>
                    </div>
                    <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12">
                        <div class="news-box">
                            <figure><img src="images/1.jpg" alt="img" /></figure>
                            <h3>Días de Festejar a Mamá</h3>
                            <span>Mayo 10</span><br>
                            <button type="button" class="buy2" data-bs-toggle="modal" data-bs-target="#myModal">Eliminar</button><br><br><br><br>
                        </div>

                    </div>


                </div>
                
               
            </div>
            <!-- Modal-->
           <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Eliminar oferta</h4>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                        </div>
                        <!-- Modal body -->
                        <div class="modal-body">

                            <h5 class="page-section-heading2 text-center text-secondary mb-0">¿Desea eliminar la oferta?</h5>

                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">No</button>

                            <a href="index.jsp" ><button type="button" class="btn btn-dark" data-bs-dismiss="modal">Sí</button></a>
                    </div>
                </div>
            </div> 
        </div> 

        <!-- end Lastestnews -->
        <!--  footer --> 
        <footer>
            <div class="footer">
                <A name ="contacto"></A>
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 offset-md-3">
                            <ul class="sociel">
                                <li> <a href="https://twitter.com/Profeco?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"><i class="fa fa-twitter"></i></a></li>
                                <li> <a href="https://www.instagram.com/profecomx/"><i class="fa fa-instagram"></i></a></li>

                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-3 col-lg-3 col-md-6 col-sm-12">
                            <div class="contact">
                                <h3>Contacto</h3>
                                <span>Av. José Vasconcelos  208 Col. Condesa, Del.<br>
                                    Cuauhtémoc 06140 Ciudad de México<br>
                                    Teléfono: (55) 5625 6700</span>
                            </div>
                        </div>


                    </div>
                </div>
                <div class="copyright">
                    <p>Copyright 2022. Profeco 2 <a href="#inicio">Inicio</a></p>
                </div>

            </div>


        </footer>



        <!-- end footer -->
        <!-- Javascript files--> 
        <script src="js/jquery-latest.js"></script>
        <script src="js/bootstrap.js"></script>
        <link rel="stylesheet" href="app/css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script> 
        <script src="js/popper.min.js"></script> 
        <script src="js/bootstrap.bundle.min.js"></script> 
        <script src="js/jquery-3.0.0.min.js"></script> 
        <script src="js/plugin.js"></script> 
        <!-- sidebar --> 
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script> 
        <script src="js/custom.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
        <script>
            $(document).ready(function () {
                $(".fancybox").fancybox({
                    openEffect: "none",
                    closeEffect: "none"
                });

                $(".zoom").hover(function () {

                    $(this).addClass('transition');
                }, function () {

                    $(this).removeClass('transition');
                });
            });

        </script> 
    </body>


</html>