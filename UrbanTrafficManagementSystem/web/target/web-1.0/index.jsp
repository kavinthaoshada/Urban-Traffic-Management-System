<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IOT Data View</title>
    <link rel="stylesheet" href="assets/css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
</head>
<body>
<div class="row" style="height: 20px"></div>
<div class="row">
    <h1 class="mt-4 mb-4 text-center col-12">Urban Traffic Management</h1>
</div>
<div class="row" style="height: 20px"></div>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
<table id="iotDataTable">
    <thead>

    <tr class="border border-1 border-dark fs-6 fw-bold">
        <th class="text-center border border-1 ps-1 pe-1">Traffic light status</th>
        <th class="text-center border border-1">Vehicle speed</th>
        <th class="text-center border border-1 ps-3 pe-3">Latitude</th>
        <th class="text-center border border-1 ps-3 pe-3">Longitude</th>
    </tr>

    </thead>
    <tbody class="text-black fs-6 fw-normal border border-1 border-dark">

    </tbody>
    <tfoot>

         <tr>
             <td colspan="4" class="border-0 text-center">..........................................</td>
         </tr>

         <tr>
             <td colspan="1" class="border-0"></td>
             <td class="fs-6 text-center border border-1 border-dark p-1">
                 <button class="btn btn-outline-secondary w-100 fs-6 rounded-pill"
                         onclick="avgSpeed();">Average Vehicle Speed</button>
             </td>
             <td class="text-center border border-1 border-dark" id="avgSpeed"></td>
         </tr>

         <tr>
             <td colspan="1" class="border-0"></td>
             <td class="fs-6 text-center border border-1 border-dark p-1">
                 <button class="btn btn-outline-secondary w-100 fs-6 rounded-pill"
                         onclick="trafficPattern();">Identify Traffic Pattern</button>
             </td>
             <td class="text-center border border-1 border-dark" id="trafficPattern"></td>
         </tr>

         <tr>
             <td colspan="1" class="border-0"></td>
             <td class="fs-6 text-center border border-1 border-dark p-1">
                 <button class="btn btn-outline-secondary w-100 fs-6 rounded-pill"
                         onclick="trafficFlow();">Traffic Flow Analysis</button>
             </td>
             <td class="text-center border border-1 border-dark" id="trafficFlow"></td>
         </tr>

         <tr>
             <td colspan="1" class="border-0"></td>
             <td class="fs-6 text-center border border-1 border-dark p-1">
                 <button class="btn btn-outline-secondary w-100 fs-6 rounded-pill"
                         onclick="urbanMobility();">Urban Mobility Efficiency</button>
             </td>
             <td class="text-center border border-1 border-dark" id="urbanMobility"></td>
         </tr>

    </tfoot>
</table>
    </div>
</div>
<div class="row" style="height: 20px"></div>

<script src="assets/js/main.js"></script>
<script src="assets/js/bootstrap.bundle.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script>
    window.onload = function() {
        getIOTData();
        setInterval(getIOTData, 2000);
    };

    function getIOTData() {
        fetch("data-view", {
            method: "GET"
        }).then(response => {
            if (!response.ok) {
                throw new Error("Network error");
            }
            return response.json();
        }).then(data => {
            updateTable(data);
        }).catch(error => {
            console.error("Error", error);
        });
    }

    function updateTable(data) {
        var tableBody = document.querySelector("#iotDataTable tbody");
        tableBody.innerHTML = "";
        data.forEach(item => {
            var row = document.createElement("tr");
            for (var key in item) {
                var cell = document.createElement("td");
                cell.textContent = item[key];
                row.appendChild(cell);
            }
            tableBody.appendChild(row);
        });
    }
</script>
</body>
</html>
