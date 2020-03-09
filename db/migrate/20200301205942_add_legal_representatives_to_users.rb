class AddLegalRepresentativesToUsers < ActiveRecord::Migration[5.1]
  def change
    add_column :users, :legal_representatives, :text
  end
end
