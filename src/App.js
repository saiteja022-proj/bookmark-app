import React, { useEffect, useState } from "react";
import axios from "axios";


const API_URL = "http://localhost:8080/api/bookmarks";

function App() {
  const [bookmarks, setBookmarks] = useState([]);
  const [title, setTitle] = useState("");
  const [url, setUrl] = useState("");
  const [editId, setEditId] = useState(null);

  useEffect(() => {
    fetchBookmarks();
  }, []);

  const fetchBookmarks = async () => {
    const res = await axios.get(API_URL);
    setBookmarks(res.data);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (editId) {
      await axios.put(`${API_URL}/${editId}`, { title, url });
      setEditId(null);
    } else {
      await axios.post(API_URL, { title, url });
    }

    setTitle("");
    setUrl("");
    fetchBookmarks();
  };

  const handleEdit = (bookmark) => {
    setTitle(bookmark.title);
    setUrl(bookmark.url);
    setEditId(bookmark.id);
  };

  const handleDelete = async (id) => {
    await axios.delete(`${API_URL}/${id}`);
    fetchBookmarks();
  };

  return (
    <div style={{ display: "flex", justifyContent: "center", marginTop: "50px" ,backgroundColor:"black" }}>
    <div style={{ padding: "20px", color: "red" }}>
      <h2>Bookmark Manager</h2>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="TITLE"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          required style={{backgroundColor:"black", color:"red"}}
        /><br/><br/>
        <input
          type="text"
          placeholder="URL"
          value={url}
          onChange={(e) => setUrl(e.target.value)}
          required style={{backgroundColor:"black", color:"red"}}
        /><br/><br/>
        <button type="submit" style={{backgroundColor:"red", color:"black"}}>
          {editId ? "Update" : "Add"}
        </button>
      </form>

      <ul>
        {bookmarks.map((bookmark) => (
          <li key={bookmark.id}>
            <a href={bookmark.url} target="_blank" rel="noreferrer" style={{textDecoration:"none", color:"red"}}>
              {bookmark.title}
            </a>
            <button onClick={() => handleEdit(bookmark)} style={{backgroundColor:"red", color:"black"}}>Edit</button>
            <button onClick={() => handleDelete(bookmark.id)} style={{backgroundColor:"red", color:"black"}}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
    </div>
  );
}

export default App;