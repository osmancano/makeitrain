<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Weather Forecasting</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/weather-icons/2.0.5/css/weather-icons.min.css">
    <link href="/secure/weather.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        var x = document.getElementById("body");
        function getLocation()
        {
            if (navigator.geolocation)
            {
                navigator.geolocation.getCurrentPosition(bindPosition);
            }
            else {
                x.innerHTML = "Geolocation is not supported by this browser.";
            }
        }
        function bindPosition(position) {
            $("input[name='latitude']").val(position.coords.latitude);
            $("input[name='longitude']").val(position.coords.longitude);
        }

        $( document ).ready(function() {
            $("#btnBoards").click(function(event) {
                event.preventDefault();
                $.get($(this).attr('href'), function(data, status){
                    $("#mainDiv").html(data);
                });
            });
            $("#btnUsers").click(function(event) {
                event.preventDefault();
                $.get($(this).attr('href'), function(data, status){
                    $("#mainDiv").html(data);
                });
            });
        });
    </script>
</head>
<body onload="getLocation()">

<!-- NAV BAR -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.php">Weather</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li ><a href="#" onclick="document.getElementById('loc').submit(); return false;"><i class="fa fa-location-arrow"></i></a></li>
            </ul>

            <form class="navbar-form navbar-left" id="loc" name="loc" method="post" action="/secure/forecast">
                <div class="form-group">
                    <input type="text" class="form-control" required id="latitude" name="latitude" placeholder="Latitude">
                    <input type="text" class="form-control" required id="longitude" name="longitude" placeholder="Longitude">
                </div>
                <button class="btn btn-success" id="find" type="submit" value="find" />GO</button>
            </form>

            <ul class="nav navbar-nav navbar-right">
                <li><a>Welcome &nbsp;<span class="badge"><c:out value="${user.displayName}"/></span></a></li>
                <li><a href="/secure/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>


<div class="container">
    <br><br>
    <div class="row">
        <c:if test="${currently!=null}">
        <h3 class="ml-15 text-info"><small><c:out value="${formatedAddress}"/></small></h3>
        <!-- CURRENT CONDITIONS -->
        <div class="col-md-6 col-sm-6">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="no-margin">
                        <strong>Current Conditions</strong>
                        <small class="text-warning hidden-xs">
                            <c:out value="${dateTime}"/>
                        </small>
                    </h3>
                </div>
                <div class="panel-body">
                    <div class="col-md-2 no-padding inline">
                        <canvas class="<c:out value="${currently.icon}"/>" width="64" height="120"></canvas>
                    </div>

                    <div class="col-md-10">
                        <div class="temp"><c:out value="${currently.temperature}"/><i class="wi wi-degrees"></i></div>
                        <strong><c:out value="${currently.summary}"/></strong> <br>
                        <c:out value="${minutely.summary}"/> <br>
                        <i class="wi wi-humidity"></i> <c:out value="${currently.humidity}"/>% &nbsp;&nbsp; Dew Point: <?php echo round($curDewPoint); ?>&deg; <br>
                        <i class="wi wi-cloudy"></i> <c:out value="${currently.cloudCover}"/>% &nbsp;&nbsp; <i class="wi wi-barometer"></i> <c:out value="${currently.pressure}"/><br>
                        <i class="wi wi-strong-wind"></i> <c:out value="${currently.windSpeed}"/> mph
                        <c:if test="$currently.windBearing > 338 && currently.windBearing < 23">
                            <i class="wi wi-direction-down"></i>
                        </c:if>
                        <c:if test="$currently.windBearing > 23 && currently.windBearing < 68">
                            <i class="wi wi-direction-down-right"></i>
                        </c:if>
                        <c:if test="$currently.windBearing > 68 && currently.windBearing < 113">
                            <i class="wi wi-direction-left"></i>
                        </c:if>
                        <c:if test="$currently.windBearing > 113 && currently.windBearing < 158">
                            <i class="wi wi-direction-left"></i>
                        </c:if>
                        <c:if test="$currently.windBearing > 158 && currently.windBearing < 203">
                            <i class="wi wi-direction-up"></i>
                        </c:if>
                        <c:if test="$currently.windBearing > 203 && currently.windBearing < 258">
                            <i class="wi wi-direction-up-right"></i>
                        </c:if>
                        <c:if test="$currently.windBearing > 248 && currently.windBearing < 293">
                            <i class="wi wi-direction-up-right"></i>
                        </c:if>
                        <c:if test="$currently.windBearing > 293 && currently.windBearing < 338">
                            <i class="wi wi-direction-up-right"></i>
                        </c:if>
                        &nbsp;&nbsp;&nbsp; <i class="fa fa-eye"></i> <c:out value="${currently.visibility}"/> mi <br>

                    </div>
                </div>
            </div>  <!-- /panel -->
        </div> <!-- /row -->
            <div class="col-md-3 col-sm-3">

            </div>
        <div class="col-md-3 col-sm-3">
            <h3 class="ml-15 text-info">History</h3>
            <div class="row">
                <c:forEach items="${user.history}" var="aHistory">
                    <h3 class="ml-15 text-info"><small><c:out value="${aHistory.formatedAddress}"/></small></h3>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="no-margin">
                                <strong>Conditions</strong>
                                <small class="text-warning hidden-xs">
                                    <c:out value="${aHistory.dateTime}"/>
                                </small>
                            </h3>
                        </div>
                        <div class="panel-body">
                            <div class="col-md-2 no-padding inline">
                                <canvas class="<c:out value="${aHistory.icon}"/>" width="64" height="120"></canvas>
                            </div>

                            <div class="col-md-10">
                                <div class="temp"><c:out value="${aHistory.temperature}"/><i class="wi wi-degrees"></i></div>
                                <strong><c:out value="${aHistory.summary}"/></strong> <br>
                                <c:out value="${aHistory.summary}"/> <br>
                                <i class="wi wi-humidity"></i> <c:out value="${aHistory.humidity}"/>% &nbsp;&nbsp; Dew Point: <?php echo round($curDewPoint); ?>&deg; <br>
                                <i class="wi wi-cloudy"></i> <c:out value="${aHistory.cloudCover}"/>% &nbsp;&nbsp; <i class="wi wi-barometer"></i> <c:out value="${aHistory.pressure}"/><br>
                                <i class="wi wi-strong-wind"></i> <c:out value="${aHistory.windSpeed}"/> mph
                                &nbsp;&nbsp;&nbsp; <i class="fa fa-eye"></i> <c:out value="${aHistory.visibility}"/> mi <br>

                            </div>
                        </div>
                    </div>  <!-- /panel -->
                </c:forEach>
            </div>
        </div>
        </c:if>
    </div>

</div> <!-- /container -->


<script src="/secure/skycons.js"></script>
    <script>
        var skycons = new Skycons({"color": "#ebebeb"}),
            list  = [
                "clear-day", "clear-night", "partly-cloudy-day",
                "partly-cloudy-night", "cloudy", "rain", "sleet", "snow", "wind",
                "fog"
            ],
            i;

        for(i = list.length; i--; ) {
            var weatherType = list[i],
                elements = document.getElementsByClassName( weatherType );
            for (e = elements.length; e--;){
                skycons.set( elements[e], weatherType );
            }
        }

        skycons.play();

</script>

</body>
</html>
