const express = require('express');
const app = express();

let counter = 0;

// Simulated API: alternates between success and failure
app.get('/simulate', (req, res) => {
    counter++;
    console.log(counter);

    if (counter > 5 && counter % 3 === 0) {
        // Simulate success
        res.status(200).send({ message: 'Success' });
    }
    else {
        // Simulate failure
        res.status(500).send({ error: 'Failure' });
    }
});

// Start the server
const PORT = 4000;
app.listen(PORT, () => {
    console.log(`Simulated API running on http://localhost:${PORT}`);
});
