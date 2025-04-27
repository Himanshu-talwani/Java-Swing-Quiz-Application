const questions = [
    "Which keyword is used to define a class in Java?",
    "Which symbol is used to end a statement in Java?",
    "Which can store multiple values of the same type in Java?",
    "Which keyword is used to create an object in Java?",
    "Java is a _____ typed language.",
    "Which data type is used to store textual data in a variable?",
    "Which Java structure repeats code until a condition becomes false?",
    "How do you write a single-line comment in Java?",
    "Which function is used to print in Java?",
    "Java programs are first compiled into _____."
];

const options = [
    ["class", "method", "object", "package"],
    ["colon (:)", "comma (,)", "semicolon (;)", "dot (.)"],
    ["ArrayList", "Object", "Array", "HashMap"],
    ["class", "new", "this", "that"],
    ["Dynamically", "Statically", "Weakly", "Strongly"],
    ["char", "String", "int", "float"],
    ["if-else", "for loop", "switch", "try-catch"],
    ["// comment", "/* comment */", "# comment", "<!-- comment -->"],
    ["System.out.println()", "cout<<", "printf()", "Console.WriteLine()"],
    ["bytecode", "source code", "assembly code", "binary code"]
];

const answers = ['a', 'c', 'c', 'b', 'b', 'b', 'b', 'a', 'a', 'a'];

let currentIndex = 0;
let score = 0;

function loadQuestion() {
    if (currentIndex < questions.length) {
        document.getElementById('question').textContent = `${currentIndex + 1}. ${questions[currentIndex]}`;
        document.getElementById('optionA').textContent = `A) ${options[currentIndex][0]}`;
        document.getElementById('optionB').textContent = `B) ${options[currentIndex][1]}`;
        document.getElementById('optionC').textContent = `C) ${options[currentIndex][2]}`;
        document.getElementById('optionD').textContent = `D) ${options[currentIndex][3]}`;
    } else {
        showResult();
    }
}

function showResult() {
    document.querySelector('.quiz-container').style.display = 'none';
    document.getElementById('result').style.display = 'block';
    document.getElementById('score').textContent = `${score}/${questions.length}`;
}

function resetQuiz() {
    currentIndex = 0;
    score = 0;
    document.querySelector('.quiz-container').style.display = 'block';
    document.getElementById('result').style.display = 'none';
    loadQuestion();
}

function endQuiz() {
    alert("Thank you for playing!");
    window.location.reload();
}

document.getElementById('nextButton').addEventListener('click', () => {
    const selectedOption = document.querySelector('input[name="option"]:checked');
    if (!selectedOption) {
        alert("❗ Please select an option or click Skip!");
        return;
    }

    const selectedAnswer = selectedOption.value;
    if (selectedAnswer === answers[currentIndex]) {
        score++;
    }

    currentIndex++;
    loadQuestion();
});

document.getElementById('skipButton').addEventListener('click', () => {
    currentIndex++;
    loadQuestion();
});

loadQuestion();
