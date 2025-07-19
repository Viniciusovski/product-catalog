import React, { useState } from 'react';
import api from '../services/api';

const CategoryForm = () => {
  const [title, setTitle] = useState('');
  const [description, setDescription] = useState('');
  const [ownerId, setOwnerId] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await api.post('/categories', { title, description, ownerId });
      alert('Category created successfully!');
      setTitle('');
      setDescription('');
      setOwnerId('');
    } catch (error) {
      console.error('Error creating category:', error);
      alert('Failed to create category.');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Create Category</h2>
      <input
        type="text"
        placeholder="Title"
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        required
      />
      <input
        type="text"
        placeholder="Description"
        value={description}
        onChange={(e) => setDescription(e.target.value)}
        required
      />
      <input
        type="text"
        placeholder="Owner ID"
        value={ownerId}
        onChange={(e) => setOwnerId(e.target.value)}
        required
      />
      <button type="submit">Create</button>
    </form>
  );
};

export default CategoryForm;