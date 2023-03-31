import React from 'react';
import './css/App.css';
import { Link, Route, Routes } from 'react-router-dom';
import { Main } from './pages/Main';
import { Topics } from './pages/Topics';
import { Settings } from './pages/Settings';

function App() {
  return (
    <div className="App">
      <header className="App-header">
          <Link to="/">Home</Link>
          <Link to="/topics">Topics</Link>
          <Link to="/settings">Settings</Link>
      </header>
      <hr/>
      <main className="App-main">
        <Routes>
          <Route path="/" element={ <Main/> }/>
          <Route path="/topics" element={ <Topics/> }/>
          <Route path="/settings" element={ <Settings/> }/>
        </Routes>
      </main>
    </div>
  );
}

export default App;
