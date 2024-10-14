document.getElementById('plantForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const plantName = document.getElementById('plantName').value;
    const plantUses = document.getElementById('plantUses').value;
    const wateringSchedule = document.getElementById('wateringSchedule').value;
    const growingTips = document.getElementById('growingTips').value;

    const plantItem = document.createElement('li');
    plantItem.innerHTML = `
        <strong>${plantName}</strong><br>
        <em>Uses:</em> ${plantUses}<br>
        <em>Watering Schedule:</em> ${wateringSchedule}<br>
        <em>Growing Tips:</em> ${growingTips}
    `;

    document.getElementById('plantDisplay').appendChild(plantItem);
    document.getElementById('plantForm').reset();
});

