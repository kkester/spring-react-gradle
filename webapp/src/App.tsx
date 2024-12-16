import React from 'react';
import './css/App.css';
import { Link, Route, Routes } from 'react-router-dom';
import { Main } from './pages/Main';
import { Topics } from './pages/Topics';
import { Board } from './pages/Board';

function App() {
  return (
    <div className="App">
      <header className="App-header">
          <Link to="/">Home</Link>
          <Link to="/topics">Topics</Link>
          <Link to="/board">Board</Link>
      </header>
      <hr/>
      <main className="App-main">
        <Routes>
          <Route path="/" element={ <Main/> }/>
          <Route path="/topics" element={ <Topics/> }/>
          <Route path="/board" element={ <Board/> }/>
        </Routes>
      </main>
    </div>
  );
}

export default App;
