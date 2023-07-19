function calculateIMC() {
    const weight = parseFloat(document.getElementById('weight').value);
    const height = parseFloat(document.getElementById('height').value);

    if (isNaN(weight) || isNaN(height)) {
        document.getElementById('result').innerText = 'Por favor, ingresa valores válidos.';
    } else {
        const imc = weight / (height * height);
        const roundedIMC = imc.toFixed(2);
        let message = '';

        if (imc < 18.5) {
            message = 'Bajo peso';
        } else if (imc >= 18.5 && imc < 24.9) {
            message = 'Peso normal';
        } else if (imc >= 25 && imc < 29.9) {
            message = 'Sobrepeso';
        } else if (imc >= 30) {
            message = 'Obesidad';
        }

        document.getElementById('result').innerText = `Tu IMC es: ${roundedIMC} (${message})`;
    }
}
