function avgSpeed() {
    fetch("average-speed", {
        method: "GET"
    }).then(response => {
        if (!response.ok) {
            throw new Error("Network error");
        }
        return response.text();
    }).then(data => {
        document.getElementById("avgSpeed").textContent = data+" Km/h";
    }).catch(error => {
        console.error("Error", error);
    });
}

function trafficPattern() {
    fetch("traffic-patterns", {
        method: "GET"
    }).then(response => {
        if (!response.ok) {
            throw new Error("Network error");
        }
        return response.text();
    }).then(data => {
        document.getElementById("trafficPattern").textContent = data;
    }).catch(error => {
        console.error("Error", error);
    });
}

function trafficFlow() {
    fetch("traffic-flow", {
        method: "GET"
    }).then(response => {
        if (!response.ok) {
            throw new Error("Network error");
        }
        return response.json();
    }).then(data => {
        const trafficFlowRate = data["Traffic Flow Rate"];
        const trafficDensity = data["Traffic Density"];

        const message = "Traffic Flow Rate: " + trafficFlowRate + " vehicles/hour\n\n | " +
            "Traffic Density: " + trafficDensity + " vehicles/km";

        document.getElementById("trafficFlow").textContent = message;
    }).catch(error => {
        console.error("Error", error);
    });
}

function urbanMobility() {
    fetch("urban-mobility-efficiency", {
        method: "GET"
    }).then(response => {
        if (!response.ok) {
            throw new Error("Network error");
        }
        return response.text();
    }).then(data => {
        document.getElementById("urbanMobility").textContent = data+" (Traffic Flow Rate/Traffic Density)";
    }).catch(error => {
        console.error("Error", error);
    });
}