// Variables
let number1Input = document.getElementById("num1")
let number2Input = document.getElementById("num2")
let resultOutput = document.getElementById("result")
let operand = ""
const operandObject = {}
const integersObject = {}

// Functions
function addOperand() {
    operand = "ADD"
    console.log(operand)
}

function subOperand() {
    operand = "SUBTRACT"
    console.log(operand)
}

function mulOperand() {
    operand = "MULTIPLY"
    console.log(operand)
}

function divOperand() {
    operand = "DIVIDE"
    console.log(operand)
}

function sendToCalculate() {
    integersObject.number1 = Number(number1Input.value)
    integersObject.number2 = Number(number2Input.value)
    
    console.log(operand)
    console.log(integersObject)
    console.log(typeof integersObject.number1)

    const options = {
        headers: {
            'Content-Type': 'application/json',
        }
    }

    showOutput('');

    axios
    .all([
      axios.post('http://localhost:8081/numberservice', integersObject, options),
      axios.post('http://localhost:8081/operatorservice', operand, options)
    ])
    .then(axios.spread((numberservice, operatorservice) => showOutput(operatorservice.data)))
    .catch(err => { showOutput("Ouch !!"); alert(err); });
}

function showOutput(res) {
    document.getElementById("result").placeholder = res
}


//Event Listeners
let addButton = document.getElementById("add").addEventListener("click", addOperand)
let subButton = document.getElementById("sub").addEventListener("click", subOperand)
let mulButton = document.getElementById("mul").addEventListener("click", mulOperand)
let divButton = document.getElementById("div").addEventListener("click", divOperand)
let calcButton = document.getElementById("calc").addEventListener("click", sendToCalculate)
