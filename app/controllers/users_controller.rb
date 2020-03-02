class UsersController < ApplicationController
  before_action :set_user, only: [:show, :edit, :update]
  before_action :validate_authorization_for_user, only: [:edit, :update]
  before_action :authenticate_user!

  # GET /users/1
  def show
  end

  # GET /users/1/edit
  def edit
  end

  def index
    @users = User.all
  end

  # PATCH/PUT /users/1
  def update
    # 2015-07-23 RICHARD: Updated to use strong parameters
    if @user.update_attributes(user_params)
      redirect_to root_path, notice: 'Informações atualizadas com sucesso.'
    else
      render action: 'edit'
    end
  end


  private
    # Use callbacks to share common setup or constraints between actions.
    def set_user
      @user = User.find(params[:id])
    end

    def validate_authorization_for_user
       redirect_to root_path unless @user == current_user
    end

    # 2015-07-23 RICHARD: Added to implement strong parameters
    def user_params
      params.require(:user).permit(:name, :user, :username, :about, :location, :cnpj, :phone, :website, :city, :state, :district, :legal_representatives)
    end
  end
