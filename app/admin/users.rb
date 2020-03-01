ActiveAdmin.register User do
  permit_params :email, :password, :password_confirmation,:name, :about, :location, :username ,:cnpj, :phone, :website, :city, :state, :district, :legal_representatives

    index do
        selectable_column
        id_column
        column :email
        column :current_sign_in_at
        column :sign_in_count
        column :created_at
        actions
      end
    
      filter :email
      filter :current_sign_in_at
      filter :sign_in_count
      filter :created_at
    
      form do |f|
        f.inputs do
          f.input :name , label: 'Razão Social'
          f.input :username, label: 'Nome Fantasia'
          f.input :cnpj, label: 'CNPJ'
          f.input :phone, label: 'Telefone'
          f.input :email, label: 'E-mail'
          f.input :website, label: 'Website'
          f.input :state, label: 'Estado'
          f.input :city, label: 'Cidade'
          f.input :district, label: 'Bairro'
         
          f.input :location, label: 'Endereço'

          f.input :about, label: 'Sobre'
          f.input :legal_representatives, label: 'Representantes Legais'
          f.input :password, label: 'Senha'
          f.input :password_confirmation, label: 'Confirmação da Senha'
        end
        f.actions
      end
end
