Rails.application.routes.draw do
  resources :uploads
  devise_for :admin_users, ActiveAdmin::Devise.config
  devise_for :users, controllers: { omniauth_callbacks: "omniauth_callbacks" }
  devise_scope :user do
    authenticated :user do
      root 'pages#landing', as: :authenticated_root
    end
  
    unauthenticated do
      root 'devise/sessions#new', as: :unauthenticated_root
    end
  end
  resources :users
  get "users/sign_in"



  ActiveAdmin.routes(self)
  root :to => 'users#sign_in'
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
