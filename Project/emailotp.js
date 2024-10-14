let generatedOTP;

function sendOTP() {
    const email = document.getElementById('email').value;

    if (validateEmail(email)) {
        generatedOTP = Math.floor(100000 + Math.random() * 900000); // Generate 6-digit OTP
        alert('OTP sent to your email: ' + generatedOTP); // Replace with actual email sending logic
        document.getElementById('email-section').classList.add('hidden');
        document.getElementById('otp-section').classList.remove('hidden');
    } else {
        document.getElementById('email-message').textContent = "Please enter a valid email address.";
    }
}

function verifyOTP() {
    const enteredOTP = document.getElementById('otp').value;

    if (enteredOTP == generatedOTP) {
        document.getElementById('otp-message').textContent = "OTP verified successfully!";
        document.getElementById('otp-message').style.color = "green";
    } else {
        document.getElementById('otp-message').textContent = "Invalid OTP. Please try again.";
        document.getElementById('otp-message').style.color = "red";
    }
}

function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(String(email).toLowerCase());
}
