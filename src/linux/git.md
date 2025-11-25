ssh-keygen -t ed25519 -C "your_email@example.com"

eval "$(ssh-agent -s)"

ssh-add ~/.ssh/id_ed25519

git config user.name "Repo Specific Name"

git config user.email "repo@example.com"

