import React from 'react';
import ProductList from '../components/ProductList';
import CategoryForm from '../components/CategoryForm';
import ProductForm from '../components/ProductForm';

const HomePage = () => {
  return (
    <div>
      <h1>Product Catalog</h1>
      <CategoryForm />
      <ProductForm />
      <ProductList />
    </div>
  );
};

export default HomePage;